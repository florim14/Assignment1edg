package com.florimi.assignment;

public class Note {

    private String title, message;
    private long noteId, dateCreatedMilli;
    private Category category;

    public enum Category {PERSONAL, ANDROID, WINDOWS, iPHONE}


    public Note(String title, String message, Category category, long noteId, long dateCreatedMilli) {
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteId = noteId;
        this.dateCreatedMilli = dateCreatedMilli;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Category getCategory() {
        return category;
    }

    public long getId() {
        return noteId;
    }

    public String toString() {
        return "ID: " + noteId + " Title: " + title + " Message: " + message + " IconID: " + category.name() + " Date: " + dateCreatedMilli;
    }

    public int getAssociatedDrawable() {
        return categoryToDrawable(category);
    }

    public static int categoryToDrawable(Category noteCategory) {
        switch (noteCategory) {
            case PERSONAL:
                return R.drawable.p;
            case ANDROID:
                return R.drawable.t;
            case iPHONE:
                return R.drawable.f;
            case WINDOWS:
                return R.drawable.q;
        }

        return R.drawable.p;
    }
}