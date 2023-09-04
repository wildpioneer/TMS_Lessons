package models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Projects {
    private int offset;
    private int limit;
    private int size;
    private ProjectBuilder[] projects;
}
