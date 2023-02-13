package com.harbourspace.todolist;

import java.util.Date;

public class TodoItem {
    private int Id;
    private String Title;
    private String Description;
    private boolean IsDone;
    private Date CreatedAt;
    private  Date UpdatedAt;

    TodoItem( int id, String title, String description, boolean isDone, Date createdAt, Date updatedAt ){
        Id = id;
        Title = title;
        Description = description;
        IsDone = isDone;
        CreatedAt = createdAt;
        UpdatedAt = updatedAt;
    }

    public int getId(){ return Id; }
    public String getTitle() { return Title; }
    public String getDescription() { return  Description; }
    public boolean getIsDone() { return IsDone; }
    public Date getCreatedAt() { return CreatedAt; }
    public Date getUpdatedAt() { return UpdatedAt; }

}
