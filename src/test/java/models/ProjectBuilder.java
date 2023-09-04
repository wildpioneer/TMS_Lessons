package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import enums.ProjectType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
public class ProjectBuilder {
    private String name;
    private String announcement;
    @SerializedName(value = "show_announcement")
    private boolean isShowAnnouncement;
    @SerializedName(value = "suite_mode")
    private int typeOfProject;
    @SerializedName(value = "is_completed")
    private boolean isCompleted;
    private User user;
}
