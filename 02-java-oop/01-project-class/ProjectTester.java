public class ProjectTester {
    public static void main(String[] args) {
        Project p = new Project();

        p.setName("test");
        p.setDescription("Test description");
        System.out.println(p.elevatorPitch());
    }
}