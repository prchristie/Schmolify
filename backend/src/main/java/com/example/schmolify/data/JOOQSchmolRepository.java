package com.example.schmolify.data;

import com.example.schmolify.domain.Schmol;
import com.example.schmolify.domain.SchmolId;
import com.example.schmolify.domain.SchmolRepository;
import com.example.schmolify.generated.jooq.tables.records.SchmolRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.schmolify.generated.jooq.tables.Schmol.SCHMOL;

@Repository
public class JOOQSchmolRepository implements SchmolRepository {

    @Autowired
    private DSLContext jooq;

    @Override
    public void add(Schmol schmol) {
        jooq.insertInto(SCHMOL, SCHMOL.ID, SCHMOL.URL)
                .values(schmol.getId().getValue(), schmol.getUrl())
                .onDuplicateKeyIgnore()
                .execute();
    }

    @Override
    public Schmol getById(SchmolId id) {
        SchmolRecord record = jooq.selectFrom(SCHMOL)
                .where(SCHMOL.ID.eq(id.getValue()))
                .fetchOne();

        if (record == null) {
            return null;
        }

        return new Schmol(SchmolId.create(record.getId()), record.getUrl());
    }

    @Override
    public List<Schmol> getAll() {
        var schmols = jooq.selectFrom(SCHMOL).fetch();
        return schmols.stream().map(s -> new Schmol(SchmolId.create(s.getId()), s.getUrl())).toList();
    }
}
