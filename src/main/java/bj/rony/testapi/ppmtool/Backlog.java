package bj.rony.testapi.ppmtool;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
public class Backlog {

    private Long id;

    private Integer PTSequence = 0;

    private String projectIdentifier;

    @JsonIgnore
    private Project project;

    // OneToMany with projectTasks
   private List<ProjectTask> projectTasks = new ArrayList<>();

}
