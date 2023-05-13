/*
 * This file is generated by jOOQ.
 */
package com.example.schmolify.generated.jooq.tables.records;


import com.example.schmolify.generated.jooq.tables.Schmol;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SchmolRecord extends UpdatableRecordImpl<SchmolRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>schmolify.schmol.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>schmolify.schmol.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>schmolify.schmol.url</code>.
     */
    public void setUrl(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>schmolify.schmol.url</code>.
     */
    public String getUrl() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Schmol.SCHMOL.ID;
    }

    @Override
    public Field<String> field2() {
        return Schmol.SCHMOL.URL;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getUrl();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getUrl();
    }

    @Override
    public SchmolRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public SchmolRecord value2(String value) {
        setUrl(value);
        return this;
    }

    @Override
    public SchmolRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SchmolRecord
     */
    public SchmolRecord() {
        super(Schmol.SCHMOL);
    }

    /**
     * Create a detached, initialised SchmolRecord
     */
    public SchmolRecord(String id, String url) {
        super(Schmol.SCHMOL);

        setId(id);
        setUrl(url);
        resetChangedOnNotNull();
    }
}