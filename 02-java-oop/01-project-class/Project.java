public class Project {
    private String name;
    private String description;
    public Project() {

    }

    public Project(String name) {
        this.name = name;
        // System.out.println("Class name: " + this.getClass().getSimpleName());

    }

    public void setName(String name) {
        this.name = name;
        // System.out.println("Class name: " + this.getClass().getSimpleName());
        // System.out.println("Project name: " + name);
    }

    public void setDescription(String desc) {
        this.description = desc;
        // System.out.println(this.name + " " + this.description);
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public String elevatorPitch() {
        String pitch = this.name + ": " + this.description;
        return pitch;
    }
}