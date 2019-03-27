package letscode.sarafan.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSubscriptionId implements Serializable {
    private static final long serialVersionUID = -7624956700590198603L;
    @JsonView(Views.Id.class)
    private String channelId;
    @JsonView(Views.Id.class)
    private String subscriberId;
}
