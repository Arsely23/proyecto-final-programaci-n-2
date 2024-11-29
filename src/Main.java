import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializamos las listas para almacenar los datos de cada tabla
        ArrayList<Title> titlesList = new ArrayList<>();
        ArrayList<Sales> salesList = new ArrayList<>();
        ArrayList<Authors> authorsList = new ArrayList<>();
        ArrayList<Employee> employeesList = new ArrayList<>();
        ArrayList<Job> jobsList = new ArrayList<>();
        ArrayList<Publisher> publishersList = new ArrayList<>();
        ArrayList<Store> storesList = new ArrayList<>();
        ArrayList<Usuario> usuariosList = new ArrayList<>();
        ArrayList<Noticia> noticiasList = new ArrayList<>();

        
        // Cargar los datos desde la base de datos
        Conexion.cargarTitulos(titlesList);
        Conexion.cargarVentas(salesList);
        Conexion.cargarAutores(authorsList);
        Conexion.cargarEmpleados(employeesList);
        Conexion.cargarJobs(jobsList);
        Conexion.cargarPublishers(publishersList);  
        Conexion.cargarStores(storesList);  
        Conexion.cargarNoticias(noticiasList);
        Conexion.cargarUsuarios(usuariosList);

        boolean running = true;
        do {
            // Menú principal
            System.out.println("Main Menu:");
            System.out.println("1. Manage Titles");
            System.out.println("2. Manage Sales");
            System.out.println("3. Manage Authors");
            System.out.println("4. Manage Employees");
            System.out.println("5. Manage Jobs");
            System.out.println("6. Manage Publishers");
            System.out.println("7. Manage Stores");
            System.out.println("8. Manage Users");
            System.out.println("9. Manage Noticias");  
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (option) {
                case 1:
                    manageTitles(scanner, titlesList);
                    break;
                case 2:
                    manageSales(scanner, salesList);
                    break;
                case 3:
                    manageAuthors(scanner, authorsList);
                    break;
                case 4:
                    manageEmployees(scanner, employeesList);
                    break;
                case 5:
                    manageJobs(scanner, jobsList);
                    break;
                case 6:
                    managePublishers(scanner, publishersList);
                    break;
                case 7:
                    manageStores(scanner, storesList);
                    break;
                case 8:
                    manageUsuarios(scanner, usuariosList);
                    break;
                case 9:
                    manageNoticias(scanner, noticiasList);  
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (running);

        scanner.close();
    }
    
    
    
    
 // Submenú para manejar las noticias
    public static void manageNoticias(Scanner scanner, ArrayList<Noticia> noticiasList) {
        boolean running = true;
        while (running) {
            System.out.println("\nManage Noticias:");
            System.out.println("1. List Noticias");
            System.out.println("2. Add Noticia");
            System.out.println("3. Update Noticia");
            System.out.println("4. Delete Noticia");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (option) {
                case 1:
                    // Listar noticias
                    for (Noticia noticia : noticiasList) {
                        System.out.println(noticia);
                    }
                    break;
                case 2:
                    // Agregar noticia
                    addNoticia(scanner);
                    break;
                case 3:
                    // Actualizar noticia
                    updateNoticia(scanner);
                    break;
                case 4:
                    // Eliminar noticia
                    deleteNoticia(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Métodos para manejar las operaciones CRUD de Noticias
    public static void addNoticia(Scanner scanner) {
        System.out.print("Enter Title: ");
        String titulo = scanner.nextLine();
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();
        System.out.print("Enter News Content: ");
        String noticia = scanner.nextLine();

        // Crear y agregar la nueva noticia
        Noticia newNoticia = new Noticia(0, titulo, fecha, noticia);
        Conexion.agregarNoticia(newNoticia);
    }

    public static void updateNoticia(Scanner scanner) {
        System.out.print("Enter Noticia ID to update: ");
        int idNoticia = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer de entrada
        System.out.print("Enter New Title: ");
        String titulo = scanner.nextLine();
        System.out.print("Enter New Date: ");
        String fecha = scanner.nextLine();
        System.out.print("Enter New News Content: ");
        String noticia = scanner.nextLine();

  
        Noticia updatedNoticia = new Noticia(idNoticia, titulo, fecha, noticia);
        Conexion.actualizarNoticia(updatedNoticia);
    }

    public static void deleteNoticia(Scanner scanner) {
        System.out.print("Enter Noticia ID to delete: ");
        int idNoticia = scanner.nextInt();
        Conexion.eliminarNoticia(idNoticia);
    }

    
 // Submenú para manejar los usuarios
    public static void manageUsuarios(Scanner scanner, ArrayList<Usuario> usuariosList) {
        boolean running = true;
        while (running) {
            System.out.println("\nManage Usuarios:");
            System.out.println("1. List Users");
            System.out.println("2. Add User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (option) {
                case 1:
                    // Listar usuarios
                    for (Usuario usuario : usuariosList) {
                        System.out.println(usuario);
                    }
                    break;
                case 2:
                    // Agregar usuario
                    addUser(scanner);
                    break;
                case 3:
                    // Actualizar usuario
                    updateUser(scanner);
                    break;
                case 4:
                    // Eliminar usuario
                    deleteUser(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Métodos para manejar las operaciones CRUD de Usuarios
    public static void addUser(Scanner scanner) {
        System.out.print("Enter Username: ");
        String usuario = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter User Level (1 - Admin, 2 - User, etc.): ");
        int nivel = scanner.nextInt();

        // Crear y agregar el nuevo usuario
        Usuario newUser = new Usuario(0, usuario, password, nivel);
        Conexion.agregarUsuario(newUser);
    }

    public static void updateUser(Scanner scanner) {
        System.out.print("Enter User ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer de entrada
        System.out.print("Enter New Username: ");
        String usuario = scanner.nextLine();
        System.out.print("Enter New Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter New User Level: ");
        int nivel = scanner.nextInt();

    
        Usuario updatedUser = new Usuario(id, usuario, password, nivel);
        Conexion.actualizarUsuario(updatedUser);
    }

    public static void deleteUser(Scanner scanner) {
        System.out.print("Enter User ID to delete: ");
        int id = scanner.nextInt();
        Conexion.eliminarUsuario(id);
    }

    
    
 
    public static void manageStores(Scanner scanner, ArrayList<Store> storesList) {
        boolean running = true;
        while (running) {
            System.out.println("\nManage Stores:");
            System.out.println("1. List Stores");
            System.out.println("2. Add Store");
            System.out.println("3. Update Store");
            System.out.println("4. Delete Store");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (option) {
                case 1:
                    // Listar tiendas
                    for (Store store : storesList) {
                        System.out.println(store);
                    }
                    break;
                case 2:
                    // Agregar tienda
                    addStore(scanner);
                    break;
                case 3:
                    // Actualizar tienda
                    updateStore(scanner);
                    break;
                case 4:
                    // Eliminar tienda
                    deleteStore(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Métodos para manejar las operaciones CRUD de Stores
    public static void addStore(Scanner scanner) {
        System.out.print("Enter Store ID: ");
        String storId = scanner.nextLine();
        System.out.print("Enter Store Name: ");
        String storName = scanner.nextLine();
        System.out.print("Enter Store Address: ");
        String storAddress = scanner.nextLine();
        System.out.print("Enter City: ");
        String city = scanner.nextLine();
        System.out.print("Enter State: ");
        String state = scanner.nextLine();
        System.out.print("Enter Zip Code: ");
        String zip = scanner.nextLine();

        // Crear y agregar la nueva tienda
        Store newStore = new Store(storId, storName, storAddress, city, state, zip);
        Conexion.agregarStore(newStore);
    }

    public static void updateStore(Scanner scanner) {
        System.out.print("Enter Store ID to update: ");
        String storId = scanner.nextLine();
        System.out.print("Enter New Store Name: ");
        String storName = scanner.nextLine();
        System.out.print("Enter New Store Address: ");
        String storAddress = scanner.nextLine();
        System.out.print("Enter New City: ");
        String city = scanner.nextLine();
        System.out.print("Enter New State: ");
        String state = scanner.nextLine();
        System.out.print("Enter New Zip Code: ");
        String zip = scanner.nextLine();

        
        Store updatedStore = new Store(storId, storName, storAddress, city, state, zip);
        Conexion.actualizarStore(updatedStore);
    }

    public static void deleteStore(Scanner scanner) {
        System.out.print("Enter Store ID to delete: ");
        String storId = scanner.nextLine();
        Conexion.eliminarStore(storId);
    }


    
    public static void manageTitles(Scanner scanner, ArrayList<Title> titlesList) {
        boolean running = true;
        while (running) {
            System.out.println("\nManage Titles:");
            System.out.println("1. List Titles");
            System.out.println("2. Add Title");
            System.out.println("3. Update Title");
            System.out.println("4. Delete Title");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (option) {
                case 1:
                    // Listar títulos
                    for (Title title : titlesList) {
                        System.out.println(title);
                    }
                    break;
                case 2:
                    // Agregar título
                    addTitle(scanner);
                    break;
                case 3:
                    // Actualizar título
                    updateTitle(scanner);
                    break;
                case 4:
                    // Eliminar título
                    deleteTitle(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Submenú para manejar las ventas
    public static void manageSales(Scanner scanner, ArrayList<Sales> salesList) {
        boolean running = true;
        while (running) {
            System.out.println("\nManage Sales:");
            System.out.println("1. List Sales");
            System.out.println("2. Add Sale");
            System.out.println("3. Update Sale");
            System.out.println("4. Delete Sale");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (option) {
                case 1:
                    // Listar ventas
                    for (Sales sale : salesList) {
                        System.out.println(sale);
                    }
                    break;
                case 2:
                    // Agregar venta
                    addSale(scanner);
                    break;
                case 3:
                    // Actualizar venta
                    updateSale(scanner);
                    break;
                case 4:
                    // Eliminar venta
                    deleteSale(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Submenú para manejar los autores
    public static void manageAuthors(Scanner scanner, ArrayList<Authors> authorsList) {
        boolean running = true;
        while (running) {
            System.out.println("\nManage Authors:");
            System.out.println("1. List Authors");
            System.out.println("2. Add Author");
            System.out.println("3. Update Author");
            System.out.println("4. Delete Author");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (option) {
                case 1:
                    // Listar autores
                    for (Authors author : authorsList) {
                        System.out.println(author);
                    }
                    break;
                case 2:
                    // Agregar autor
                    addAuthor(scanner);
                    break;
                case 3:
                    // Actualizar autor
                    updateAuthor(scanner);
                    break;
                case 4:
                    // Eliminar autor
                    deleteAuthor(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Métodos para manejar las operaciones CRUD de Titles
    public static void addTitle(Scanner scanner) {
        System.out.print("Enter Title ID: ");
        String titleId = scanner.nextLine();
        System.out.print("Enter Title Name: ");
        String titleName = scanner.nextLine();
        // Recoger los demás datos necesarios de la misma forma...

        // Crear y agregar el nuevo título
        Title newTitle = new Title(titleId, titleName, "Type", "P001", 20.99, 1000, 15, 500, "Notes", "2023-01-01");
        Conexion.agregarTitulo(newTitle);
    }

    public static void updateTitle(Scanner scanner) {
        System.out.print("Enter Title ID to update: ");
        String titleId = scanner.nextLine();
        // Aquí puedes recoger los datos del nuevo título para actualizar...

       
        Title updatedTitle = new Title(titleId, "Updated Title", "Updated Type", "P001", 29.99, 1500, 20, 600, "Updated Notes", "2023-02-01");
        Conexion.actualizarTitulo(updatedTitle);
    }

    public static void deleteTitle(Scanner scanner) {
        System.out.print("Enter Title ID to delete: ");
        String titleId = scanner.nextLine();
        Conexion.eliminarTitulo(titleId);
    }

    // Métodos para manejar las operaciones CRUD de Sales
    public static void addSale(Scanner scanner) {
        System.out.print("Enter Store ID: ");
        String storId = scanner.nextLine();
        System.out.print("Enter Order Number: ");
        String ordNum = scanner.nextLine();
        // Recoger los demás datos necesarios de la misma forma...

        // Crear y agregar la nueva venta
        Sales newSale = new Sales(storId, ordNum, "2023-01-01", 10, "Cash", "T001");
        Conexion.agregarVenta(newSale);
    }

    public static void updateSale(Scanner scanner) {
        System.out.print("Enter Sale Order Number to update: ");
        String ordNum = scanner.nextLine();
        // Recoger datos de la venta a actualizar

        
        Sales updatedSale = new Sales("S001", ordNum, "2023-02-01", 15, "Credit", "T001");
        Conexion.actualizarVenta(updatedSale);
    }

    public static void deleteSale(Scanner scanner) {
        System.out.print("Enter Sale Order Number to delete: ");
        String ordNum = scanner.nextLine();
        Conexion.eliminarVenta("S001", ordNum, "T001");
    }

    // Métodos para manejar las operaciones CRUD de Authors
    public static void addAuthor(Scanner scanner) {
        System.out.print("Enter Author ID: ");
        String auId = scanner.nextLine();
        System.out.print("Enter Author Last Name: ");
        String auLname = scanner.nextLine();
        System.out.print("Enter Author First Name: ");
        String auFname = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        // Recoger los demás datos de la misma forma...

        // Crear y agregar el nuevo autor
        Authors newAuthor = new Authors(auId, auLname, auFname, phone, "Address", "City", "State", "12345", true);
        Conexion.agregarAutor(newAuthor);
    }

    public static void updateAuthor(Scanner scanner) {
        System.out.print("Enter Author ID to update: ");
        String auId = scanner.nextLine();
        // Aquí puedes recoger los datos del autor para actualizar...

        
        Authors updatedAuthor = new Authors(auId, "Updated Lname", "Updated Fname", "Updated Phone", "Updated Address", "Updated City", "Updated State", "54321", false);
        Conexion.actualizarAutor(updatedAuthor);
    }

    public static void deleteAuthor(Scanner scanner) {
        System.out.print("Enter Author ID to delete: ");
        String auId = scanner.nextLine();
        Conexion.eliminarAutor(auId);
    
    
    }


 // Submenú para manejar los empleados
    public static void manageEmployees(Scanner scanner, ArrayList<Employee> employeesList) {
        boolean running = true;
        while (running) {
            System.out.println("\nManage Employees:");
            System.out.println("1. List Employees");
            System.out.println("2. Add Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (option) {
                case 1:
                    // Listar empleados
                    for (Employee employee : employeesList) {
                        System.out.println(employee);
                    }
                    break;
                case 2:
                    // Agregar empleado
                    addEmployee(scanner);
                    break;
                case 3:
                    // Actualizar empleado
                    updateEmployee(scanner);
                    break;
                case 4:
                    // Eliminar empleado
                    deleteEmployee(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    
    
 // Submenú para manejar los trabajos
    public static void manageJobs(Scanner scanner, ArrayList<Job> jobsList) {
        boolean running = true;
        while (running) {
            System.out.println("\nManage Jobs:");
            System.out.println("1. List Jobs");
            System.out.println("2. Add Job");
            System.out.println("3. Update Job");
            System.out.println("4. Delete Job");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (option) {
                case 1:
                    // Listar trabajos
                    for (Job job : jobsList) {
                        System.out.println(job);
                    }
                    break;
                case 2:
                    // Agregar trabajo
                    addJob(scanner);
                    break;
                case 3:
                    // Actualizar trabajo
                    updateJob(scanner);
                    break;
                case 4:
                    // Eliminar trabajo
                    deleteJob(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Métodos para manejar las operaciones CRUD de Jobs
    public static void addJob(Scanner scanner) {
        System.out.print("Enter Job ID: ");
        int jobId = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer de entrada
        System.out.print("Enter Job Description: ");
        String jobDesc = scanner.nextLine();
        System.out.print("Enter Min Level: ");
        int minLvl = scanner.nextInt();
        System.out.print("Enter Max Level: ");
        int maxLvl = scanner.nextInt();

        // Crear y agregar el nuevo trabajo
        Job newJob = new Job(jobId, jobDesc, minLvl, maxLvl);
        Conexion.agregarJob(newJob);
    }

    public static void updateJob(Scanner scanner) {
        System.out.print("Enter Job ID to update: ");
        int jobId = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer de entrada
        System.out.print("Enter New Job Description: ");
        String jobDesc = scanner.nextLine();
        System.out.print("Enter New Min Level: ");
        int minLvl = scanner.nextInt();
        System.out.print("Enter New Max Level: ");
        int maxLvl = scanner.nextInt();

       
        Job updatedJob = new Job(jobId, jobDesc, minLvl, maxLvl);
        Conexion.actualizarJob(updatedJob);
    }

    public static void deleteJob(Scanner scanner) {
        System.out.print("Enter Job ID to delete: ");
        int jobId = scanner.nextInt();
        Conexion.eliminarJob(jobId);
    }

    
 // Submenú para manejar los publicadores
    public static void managePublishers(Scanner scanner, ArrayList<Publisher> publishersList) {
        boolean running = true;
        while (running) {
            System.out.println("\nManage Publishers:");
            System.out.println("1. List Publishers");
            System.out.println("2. Add Publisher");
            System.out.println("3. Update Publisher");
            System.out.println("4. Delete Publisher");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (option) {
                case 1:
                    // Listar publicadores
                    for (Publisher publisher : publishersList) {
                        System.out.println(publisher);
                    }
                    break;
                case 2:
                    // Agregar publicador
                    addPublisher(scanner);
                    break;
                case 3:
                    // Actualizar publicador
                    updatePublisher(scanner);
                    break;
                case 4:
                    // Eliminar publicador
                    deletePublisher(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Métodos para manejar las operaciones CRUD de Publishers
    public static void addPublisher(Scanner scanner) {
        System.out.print("Enter Publisher ID: ");
        String pubId = scanner.nextLine();
        System.out.print("Enter Publisher Name: ");
        String pubName = scanner.nextLine();
        System.out.print("Enter City: ");
        String city = scanner.nextLine();
        System.out.print("Enter State: ");
        String state = scanner.nextLine();
        System.out.print("Enter Country: ");
        String country = scanner.nextLine();

        // Crear y agregar el nuevo publicador
        Publisher newPublisher = new Publisher(pubId, pubName, city, state, country);
        Conexion.agregarPublisher(newPublisher);
    }

    public static void updatePublisher(Scanner scanner) {
        System.out.print("Enter Publisher ID to update: ");
        String pubId = scanner.nextLine();
        System.out.print("Enter New Publisher Name: ");
        String pubName = scanner.nextLine();
        System.out.print("Enter New City: ");
        String city = scanner.nextLine();
        System.out.print("Enter New State: ");
        String state = scanner.nextLine();
        System.out.print("Enter New Country: ");
        String country = scanner.nextLine();

        
        Publisher updatedPublisher = new Publisher(pubId, pubName, city, state, country);
        Conexion.actualizarPublisher(updatedPublisher);
    }

    public static void deletePublisher(Scanner scanner) {
        System.out.print("Enter Publisher ID to delete: ");
        String pubId = scanner.nextLine();
        Conexion.eliminarPublisher(pubId);
    }

    
    
    
    // Métodos para manejar las operaciones CRUD de Employees
    public static void addEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID: ");
        String empId = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String fname = scanner.nextLine();
        System.out.print("Enter Middle Initial: ");
        String minit = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lname = scanner.nextLine();
        System.out.print("Enter Job ID: ");
        int jobId = scanner.nextInt();
        System.out.print("Enter Job Level: ");
        int jobLvl = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer de entrada
        System.out.print("Enter Publisher ID: ");
        String pubId = scanner.nextLine();
        System.out.print("Enter Hire Date (YYYY-MM-DD): ");
        String hireDate = scanner.nextLine();

        // Crear y agregar el nuevo empleado
        Employee newEmployee = new Employee(empId, fname, minit, lname, jobId, jobLvl, pubId, hireDate);
        Conexion.agregarEmpleado(newEmployee);
    }

    public static void updateEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID to update: ");
        String empId = scanner.nextLine();
        // Recoger los datos del nuevo empleado para actualizar...

       
        Employee updatedEmployee = new Employee(empId, "Updated Fname", "M", "Updated Lname", 1, 2, "P001", "2023-05-01");
        Conexion.actualizarEmpleado(updatedEmployee);
    }

    public static void deleteEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID to delete: ");
        String empId = scanner.nextLine();
        Conexion.eliminarEmpleado(empId);
    }


}
