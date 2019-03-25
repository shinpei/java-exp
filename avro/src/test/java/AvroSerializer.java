import example.avro.User;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AvroSerializer {

    public byte[] serializeAvro(User user) {
        DatumWriter<User> writer = new SpecificDatumWriter<>(User.class);

        byte[] data = new byte[0];
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        Encoder encoder = null;

        try {
            encoder = EncoderFactory.get()
                    .binaryEncoder(bao, null);
            writer.write(user, encoder);
            encoder.flush();
            data = bao.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
