/*
 * This file is generated by jOOQ.
 */
package com.example.schmolify.generated.jooq;


import com.example.schmolify.generated.jooq.tables.Schmol;
import com.example.schmolify.generated.jooq.tables.records.SchmolRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * schmolify.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<SchmolRecord> KEY_SCHMOL_PRIMARY = Internal.createUniqueKey(Schmol.SCHMOL, DSL.name("KEY_schmol_PRIMARY"), new TableField[] { Schmol.SCHMOL.ID }, true);
}
