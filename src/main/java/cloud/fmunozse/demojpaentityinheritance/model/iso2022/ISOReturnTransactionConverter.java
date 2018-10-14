package cloud.fmunozse.demojpaentityinheritance.model.iso2022;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public class ISOReturnTransactionConverter implements AttributeConverter<ISOReturnTransaction, String> {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(ISOReturnTransaction attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ISOReturnTransaction convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData,ISOReturnTransaction.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
