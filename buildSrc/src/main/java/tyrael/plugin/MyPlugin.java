package tyrael.plugin;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

public class MyPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        System.out.println("22222222222222222");
        Task task = project.task("testTask");
        task.doFirst("testAction", new Action<Task>() {
            @Override
            public void execute(Task task) {
                System.out.println("testAction execute");
                String projectRoot = task.getProject().getRootDir().getAbsolutePath();
                String src = projectRoot + "/app/src/main/cpp/.h";
                String dest = projectRoot + "/app/src/main/java/wang/tyrael/learnandroid/.java";
//                ConstTranslateTask constTranslateTask = new ConstTranslateTask(src, dest);
//                constTranslateTask.run();
            }
        });
    }
}

