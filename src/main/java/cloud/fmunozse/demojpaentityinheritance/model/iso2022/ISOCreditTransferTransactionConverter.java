package cloud.fmunozse.demojpaentityinheritance.model.iso2022;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public class ISOCreditTransferTransactionConverter implements AttributeConverter<ISOCreditTransferTransaction, String> {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(ISOCreditTransferTransaction attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ISOCreditTransferTransaction convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData,ISOCreditTransferTransaction.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
