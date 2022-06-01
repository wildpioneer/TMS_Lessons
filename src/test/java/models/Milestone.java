package models;


import com.sun.istack.internal.NotNull;
import lombok.Data;

@Data
public class Milestone {
    @NotNull
    String name;
    String references;
}
