package ar.edu.unq.cryptop2p.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TradeVolumeLocalDateDto implements Serializable {
    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private Long userId;
}
