package Project.App.TaskManager.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private LocalDate createdDate = LocalDate.now();

    // Comment is made by a user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;

    // Each comment is associated with a task
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
