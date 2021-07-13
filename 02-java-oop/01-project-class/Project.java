public class Project {
    private String name;
    private String description;
    private static String defaultName = "Default Name";
    private static String defaultDescription = "Default Description";
    private double initialCost = 0;

    public void setName(String name) {
        this.name = name;
        // System.out.println("Class name: " + this.getClass().getSimpleName());
        // System.out.println("Project name: " + name);
    }
    public void setDescription(String desc) {
        this.description = desc;
        // System.out.println(this.name + " " + this.description);
    }
    public void setInitialCost(double price) {
        this.initialCost = price;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getCost() {
        return initialCost;
    }
    
    public Project() {
        this.name = defaultName;
        this.description = defaultDescription;
    }

    public Project(String name) {
        this.name = name;
        this.description = defaultDescription;
        // System.out.println("Class name: " + this.getClass().getSimpleName());
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public Project(String name, double price, String description) {
        this.name = name;
        this.initialCost = price;
        this.description = description;
    }

    public String elevatorPitch() {
        return String.format("%s (%.02f): %s", name, initialCost, description);
    }
}