package validation;

import com.google.protobuf.GeneratedMessageV3;
import io.envoyproxy.pgv.ReflectiveValidatorIndex;
import io.envoyproxy.pgv.ValidationException;
import io.envoyproxy.pgv.ValidatorIndex;

public class ProtoValidationService {
    private final ValidatorIndex validatorIndex = new ReflectiveValidatorIndex();

    public void validate(final GeneratedMessageV3 generatedMessageV3) {
        try {
            validatorIndex.validatorFor(generatedMessageV3.getClass()).assertValid(generatedMessageV3);
        } catch (ValidationException validationException) {
            throw new ProtoValidationException(validationException.getMessage());
        }
    }
}
