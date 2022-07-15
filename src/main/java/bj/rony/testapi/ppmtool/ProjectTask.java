package bj.rony.testapi.ppmtool;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ProjectTask {


    private Long id;

    private String projectSequence;

    private String summary;
    private String acceptanceCriteria;
    private String status;
    private Integer priority;

    private Date dueDate;

    // ManyToOne with Backlog
    private String projectIdentifier;

    @JsonIgnore
    private Backlog backlog;

    private Date createdAt;
    private Date updatedAt;


    @Override
    public String toString(){
        return "ProjectTask{" +
                "id="+id+
                "projectSequence="+projectSequence+
                "summary="+summary+
                "acceptanceCriteria="+acceptanceCriteria+
                "status="+status+
                "priority="+priority+
                "dueDate="+dueDate+
                "projectIdentifier="+projectIdentifier+
                "createdAt="+createdAt+
                "updatedAt="+updatedAt+
                "}";
    }

}
