package com.kras0t1n.thousand;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseService {
    private DatabaseReference databaseReference;

    public FirebaseService() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("games");
    }

    public void updateGameState(Games game) {
        databaseReference.setValue(game);
    }

    public void listenForGameStateChanges(String gameId, ValueEventListener listener) {
        databaseReference.child(gameId).addValueEventListener(listener);
    }
}
