package Project.App.TaskManager.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Status status;
    private String priority;
    private LocalDate dueDate;
    private LocalDate createdDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedTo;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    private enum Status {
        ToDo,InProgress,Done
    }
}
