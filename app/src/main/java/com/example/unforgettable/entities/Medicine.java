package com.example.unforgettable.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * <h3>
 * <strong>Class that represents the structure of a {@link Medicine Medicine}</strong>
 * </h3>
 *
 * @author Luis Marques
 */
@Entity(tableName = "Medicines")
public class Medicine {

    /**
     * int reference to the id
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;

    /**
     * String reference to the name
     */
    @ColumnInfo(name = "Name")
    private String name;

    /**
     * String reference to the description
     */
    @ColumnInfo(name = "Description")
    private String description;

    /**
     * Creates an instance of a {@link Medicine medicine}
     *
     * @param name        String name
     * @param description String description
     */
    public Medicine(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Gets the id of the medicine
     *
     * @return int id of the medicine
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the medicine
     *
     * @return String name of the medicine
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the medicine
     *
     * @param name String name of the medicine
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the medicine
     *
     * @return String description of the medicine
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the medicine
     *
     * @param description String description of the medicine
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
