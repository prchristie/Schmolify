package com.example.schmolify;

import com.example.schmolify.generated.jooq.tables.records.SchmolRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.MalformedURLException;
import java.net.URL;

import static com.example.schmolify.generated.jooq.tables.Schmol.SCHMOL;

@Repository
public class JOOQSchmolRepository implements SchmolRepository {

    @Autowired
    private DSLContext jooq;

    @Override
    public void add(Schmol schmol) {
        jooq.insertInto(SCHMOL, SCHMOL.ID, SCHMOL.URL)
                .values(schmol.getId().getValue(), schmol.getUrl().toString())
                .onDuplicateKeyIgnore()
                .execute();
    }

    @Override
    public Schmol getById(SchmolId id) {
        SchmolRecord record = jooq.selectFrom(SCHMOL)
                .where(SCHMOL.ID.eq(id.getValue()))
                .fetchOne();

        try {
            return new Schmol(SchmolId.create(record.getId()), new URL(record.getUrl()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
