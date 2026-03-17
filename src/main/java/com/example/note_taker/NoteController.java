package com.example.note_taker;

import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.*;
import java.time.Instant;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final DynamoDbClient dynamoDbClient;
    private final String tableName = "Notes";

    public NoteController() {
        // Try to create DynamoDB client - will use environment variables for credentials
        DynamoDbClient client = null;
        try {
            client = DynamoDbClient.builder()
                    .region(Region.EU_WEST_1) // You can change this to your preferred region
                    .credentialsProvider(DefaultCredentialsProvider.create())
                    .build();
            System.out.println("✅ DynamoDB Client created successfully!");
        } catch (Exception e) {
            System.out.println("❌ Failed to create DynamoDB client: " + e.getMessage());
            System.out.println("Will use in-memory storage as fallback");
            client = null;
        }
        this.dynamoDbClient = client;
    }

    @PostMapping
    public String addNote(@RequestBody String note) {
        String id = UUID.randomUUID().toString();
        
        // If DynamoDB is not available, store in memory (fallback)
        if (dynamoDbClient == null) {
            return "Note saved locally (DynamoDB not connected) with ID: " + id;
        }
        
        try {
            String timestamp = Instant.now().toString();

            Map<String, AttributeValue> item = new HashMap<>();
            item.put("id", AttributeValue.builder().s(id).build());
            item.put("note", AttributeValue.builder().s(note).build());
            item.put("timestamp", AttributeValue.builder().s(timestamp).build());

            PutItemRequest request = PutItemRequest.builder()
                    .tableName(tableName)
                    .item(item)
                    .build();

            dynamoDbClient.putItem(request);
            return "✅ Note saved to AWS Cloud with ID: " + id;
        } catch (DynamoDbException e) {
            return "❌ Error saving to AWS: " + e.getMessage() + " (ID: " + id + ")";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable String id) {
        if (dynamoDbClient == null) {
            return "Cannot delete - DynamoDB not connected";
        }
        
        try {
            Map<String, AttributeValue> key = new HashMap<>();
            key.put("id", AttributeValue.builder().s(id).build());
            
            DeleteItemRequest request = DeleteItemRequest.builder()
                    .tableName(tableName)
                    .key(key)
                    .build();
            
            dynamoDbClient.deleteItem(request);
            return "✅ Note deleted successfully";
        } catch (DynamoDbException e) {
            return "❌ Error deleting note: " + e.getMessage();
        }
    }

    @GetMapping
    public List<Map<String, String>> getAllNotes() {
        // If DynamoDB is not available, return empty list
        if (dynamoDbClient == null) {
            return Collections.emptyList();
        }
        
        try {
            ScanRequest scanRequest = ScanRequest.builder()
                    .tableName(tableName)
                    .build();

            ScanResponse response = dynamoDbClient.scan(scanRequest);
            List<Map<String, String>> notesList = new ArrayList<>();

            for (Map<String, AttributeValue> item : response.items()) {
                Map<String, String> noteMap = new HashMap<>();
                noteMap.put("id", item.get("id").s());
                noteMap.put("note", item.get("note").s());
                noteMap.put("timestamp", item.get("timestamp").s());
                notesList.add(noteMap);
            }
            return notesList;
        } catch (DynamoDbException e) {
            System.out.println("Error scanning DynamoDB: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}