package com.example.schmolify.data;

import com.devskiller.friendly_id.FriendlyId;
import com.example.schmolify.domain.SchmolId;
import com.example.schmolify.domain.SchmolIdFactory;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.UUID;

@Component
public class SchmolIdFactoryImpl implements SchmolIdFactory {
    @Override
    public SchmolId idFromUrl(String url) {
        UUID result = UUID.nameUUIDFromBytes(url.getBytes());
        String id = FriendlyId.toFriendlyId(result);
        return SchmolId.create(id.substring(0, 8));
    }
}
