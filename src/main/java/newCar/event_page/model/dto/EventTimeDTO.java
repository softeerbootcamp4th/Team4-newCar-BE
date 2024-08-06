package newCar.event_page.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import newCar.event_page.model.entity.event.EventCommon;

import java.time.LocalDateTime;

@Builder
public class EventTimeDTO {

    @NotNull
    public LocalDateTime startTime;

    @NotNull
    public LocalDateTime endTime;

    public static EventTimeDTO toDTO(EventCommon eventCommon){
        return EventTimeDTO.builder()
                .startTime(eventCommon.getStartTime())
                .endTime(eventCommon.getEndTime())
                .build();
    }
}
