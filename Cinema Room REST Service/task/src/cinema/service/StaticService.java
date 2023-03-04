package cinema.service;

import cinema.model.Statics;
import org.springframework.stereotype.Service;

@Service
public class StaticService {
    RoomService roomService;
    final Statics statics;
    public StaticService(Statics statics,RoomService roomService) {
        this.statics = statics;
        this.roomService = roomService;
    }

    public void processData(){
        
    }
    public Statics getStatics(){
        return  statics;
    }
}
