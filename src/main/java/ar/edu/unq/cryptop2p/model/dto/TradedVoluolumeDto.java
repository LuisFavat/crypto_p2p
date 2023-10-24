package ar.edu.unq.cryptop2p.model.dto;


import ar.edu.unq.cryptop2p.model.UserCrypto;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import static ar.edu.unq.cryptop2p.helpers.CurrentDateTime.stringToDate;

import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TradedVoluolumeDto implements Serializable {

    @NotNull
    private String startDate;

    @NotNull
    private String endDate;

    @NotNull
    private Long userId;


    public TradeVolumeLocalDateDto convertStringToDate() throws ParseException {
        var tradeVolumeData = new TradeVolumeLocalDateDto(stringToDate(getStartDate()), stringToDate(getEndDate()),getUserId());
        return tradeVolumeData;
    }

  }


