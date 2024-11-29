import java.sql.*;
import java.util.ArrayList;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/pubs";  // Nombre de la base de datos
    private static final String USER = "root";  // Usuario de MySQL
    private static final String PASSWORD = "Arsely1234@";  // Contraseña de MySQL

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Cargar el driver de MySQL
            connection = DriverManager.getConnection(URL, USER, PASSWORD);  // Establecer la conexión
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Método para cargar todos los títulos desde la base de datos
    public static void cargarTitulos(ArrayList<Title> titlesList) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM titles";  // Consulta SQL para obtener los títulos
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String titleId = rs.getString("title_id");
                    String title = rs.getString("title");
                    String type = rs.getString("type");
                    String pubId = rs.getString("pub_id");
                    double price = rs.getDouble("price");
                    double advance = rs.getDouble("advance");
                    int royalty = rs.getInt("royalty");
                    int ytdSales = rs.getInt("ytd_sales");
                    String notes = rs.getString("notes");
                    String pubDate = rs.getString("pubdate");

                    Title titleObj = new Title(titleId, title, type, pubId, price, advance, royalty, ytdSales, notes, pubDate);
                    titlesList.add(titleObj);  // Añadir el título al ArrayList
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Could not establish connection to the database.");
        }
    }

    // Método para agregar un nuevo título a la base de datos
    public static void agregarTitulo(Title title) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO titles (title_id, title, type, pub_id, price, advance, royalty, ytd_sales, notes, pubdate) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, title.getTitleId());
                stmt.setString(2, title.getTitle());
                stmt.setString(3, title.getType());
                stmt.setString(4, title.getPubId());
                stmt.setDouble(5, title.getPrice());
                stmt.setDouble(6, title.getAdvance());
                stmt.setInt(7, title.getRoyalty());
                stmt.setInt(8, title.getYtdSales());
                stmt.setString(9, title.getNotes());
                stmt.setString(10, title.getPubdate());
                
                stmt.executeUpdate();
                System.out.println("Title added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Método para actualizar un título en la base de datos
    public static void actualizarTitulo(Title title) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE titles SET title = ?, type = ?, pub_id = ?, price = ?, advance = ?, royalty = ?, " +
                             "ytd_sales = ?, notes = ?, pubdate = ? WHERE title_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, title.getTitle());
                stmt.setString(2, title.getType());
                stmt.setString(3, title.getPubId());
                stmt.setDouble(4, title.getPrice());
                stmt.setDouble(5, title.getAdvance());
                stmt.setInt(6, title.getRoyalty());
                stmt.setInt(7, title.getYtdSales());
                stmt.setString(8, title.getNotes());
                stmt.setString(9, title.getPubdate());
                stmt.setString(10, title.getTitleId());
                
                stmt.executeUpdate();
                System.out.println("Title updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Método para eliminar un título de la base de datos
    public static void eliminarTitulo(String titleId) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM titles WHERE title_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, titleId);
                
                stmt.executeUpdate();
                System.out.println("Title deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

 // Método para cargar las ventas desde la base de datos
    public static void cargarVentas(ArrayList<Sales> salesList) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM sales";  // Consulta SQL para obtener las ventas
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String storId = rs.getString("stor_id");
                    String ordNum = rs.getString("ord_num");
                    String ordDate = rs.getString("ord_date");
                    int qty = rs.getInt("qty");
                    String payterms = rs.getString("payterms");
                    String titleId = rs.getString("title_id");

                    Sales sale = new Sales(storId, ordNum, ordDate, qty, payterms, titleId);
                    salesList.add(sale);  // Añadir la venta al ArrayList
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Could not establish connection to the database.");
        }
    }

    
 // Método para agregar una nueva venta a la base de datos
    public static void agregarVenta(Sales sale) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO sales (stor_id, ord_num, ord_date, qty, payterms, title_id) " +
                             "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, sale.getStorId());
                stmt.setString(2, sale.getOrdNum());
                stmt.setString(3, sale.getOrdDate());
                stmt.setInt(4, sale.getQty());
                stmt.setString(5, sale.getPayterms());
                stmt.setString(6, sale.getTitleId());

                stmt.executeUpdate();
                System.out.println("Sale added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
 // Método para actualizar una venta en la base de datos
    public static void actualizarVenta(Sales sale) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE sales SET ord_date = ?, qty = ?, payterms = ?, title_id = ? WHERE stor_id = ? AND ord_num = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, sale.getOrdDate());
                stmt.setInt(2, sale.getQty());
                stmt.setString(3, sale.getPayterms());
                stmt.setString(4, sale.getTitleId());
                stmt.setString(5, sale.getStorId());
                stmt.setString(6, sale.getOrdNum());

                stmt.executeUpdate();
                System.out.println("Sale updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

 // Método para eliminar una venta de la base de datos
    public static void eliminarVenta(String storId, String ordNum, String titleId) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM sales WHERE stor_id = ? AND ord_num = ? AND title_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, storId);
                stmt.setString(2, ordNum);
                stmt.setString(3, titleId);

                stmt.executeUpdate();
                System.out.println("Sale deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
 // Método para cargar los autores desde la base de datos
    public static void cargarAutores(ArrayList<Authors> authorsList) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM authors";  // Consulta SQL para obtener los autores
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String auId = rs.getString("au_id");
                    String auLname = rs.getString("au_lname");
                    String auFname = rs.getString("au_fname");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    String city = rs.getString("city");
                    String state = rs.getString("state");
                    String zip = rs.getString("zip");
                    boolean contract = rs.getBoolean("contract");

                    Authors author = new Authors(auId, auLname, auFname, phone, address, city, state, zip, contract);
                    authorsList.add(author);  // Añadir el autor al ArrayList
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Could not establish connection to the database.");
        }
    }

    
 // Método para agregar un autor a la base de datos
    public static void agregarAutor(Authors author) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO authors (au_id, au_lname, au_fname, phone, address, city, state, zip, contract) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, author.getAuId());
                stmt.setString(2, author.getAuLname());
                stmt.setString(3, author.getAuFname());
                stmt.setString(4, author.getPhone());
                stmt.setString(5, author.getAddress());
                stmt.setString(6, author.getCity());
                stmt.setString(7, author.getState());
                stmt.setString(8, author.getZip());
                stmt.setBoolean(9, author.isContract());

                stmt.executeUpdate();
                System.out.println("Author added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
 // Método para actualizar un autor en la base de datos
    public static void actualizarAutor(Authors author) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE authors SET au_lname = ?, au_fname = ?, phone = ?, address = ?, city = ?, state = ?, zip = ?, contract = ? " +
                             "WHERE au_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, author.getAuLname());
                stmt.setString(2, author.getAuFname());
                stmt.setString(3, author.getPhone());
                stmt.setString(4, author.getAddress());
                stmt.setString(5, author.getCity());
                stmt.setString(6, author.getState());
                stmt.setString(7, author.getZip());
                stmt.setBoolean(8, author.isContract());
                stmt.setString(9, author.getAuId());

                stmt.executeUpdate();
                System.out.println("Author updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
 // Método para eliminar un autor de la base de datos
    public static void eliminarAutor(String auId) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM authors WHERE au_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, auId);

                stmt.executeUpdate();
                System.out.println("Author deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
 // Método para cargar los empleados desde la base de datos
    public static void cargarEmpleados(ArrayList<Employee> employeesList) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM employee";  // Consulta SQL para obtener los empleados
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String empId = rs.getString("emp_id");
                    String fname = rs.getString("fname");
                    String minit = rs.getString("minit");
                    String lname = rs.getString("lname");
                    int jobId = rs.getInt("job_id");
                    int jobLvl = rs.getInt("job_lvl");
                    String pubId = rs.getString("pub_id");
                    String hireDate = rs.getString("hire_date");

                    Employee employee = new Employee(empId, fname, minit, lname, jobId, jobLvl, pubId, hireDate);
                    employeesList.add(employee);  // Añadir el empleado al ArrayList
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Could not establish connection to the database.");
        }
    }

 // Método para agregar un nuevo empleado a la base de datos
    public static void agregarEmpleado(Employee employee) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO employee (emp_id, fname, minit, lname, job_id, job_lvl, pub_id, hire_date) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, employee.getEmpId());
                stmt.setString(2, employee.getFname());
                stmt.setString(3, employee.getMinit());
                stmt.setString(4, employee.getLname());
                stmt.setInt(5, employee.getJobId());
                stmt.setInt(6, employee.getJobLvl());
                stmt.setString(7, employee.getPubId());
                stmt.setString(8, employee.getHireDate());

                stmt.executeUpdate();
                System.out.println("Employee added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

 // Método para actualizar un empleado en la base de datos
    public static void actualizarEmpleado(Employee employee) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE employee SET fname = ?, minit = ?, lname = ?, job_id = ?, job_lvl = ?, pub_id = ?, hire_date = ? " +
                             "WHERE emp_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, employee.getFname());
                stmt.setString(2, employee.getMinit());
                stmt.setString(3, employee.getLname());
                stmt.setInt(4, employee.getJobId());
                stmt.setInt(5, employee.getJobLvl());
                stmt.setString(6, employee.getPubId());
                stmt.setString(7, employee.getHireDate());
                stmt.setString(8, employee.getEmpId());

                stmt.executeUpdate();
                System.out.println("Employee updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

 // Método para eliminar un empleado de la base de datos
    public static void eliminarEmpleado(String empId) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM employee WHERE emp_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, empId);

                stmt.executeUpdate();
                System.out.println("Employee deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

 // Método para cargar los trabajos desde la base de datos
    public static void cargarJobs(ArrayList<Job> jobsList) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM jobs";  // Consulta SQL para obtener los trabajos
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int jobId = rs.getInt("job_id");
                    String jobDesc = rs.getString("job_desc");
                    int minLvl = rs.getInt("min_lvl");
                    int maxLvl = rs.getInt("max_lvl");

                    Job job = new Job(jobId, jobDesc, minLvl, maxLvl);
                    jobsList.add(job);  // Añadir el trabajo al ArrayList
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Could not establish connection to the database.");
        }
    }

    
 // Método para agregar un nuevo trabajo a la base de datos
    public static void agregarJob(Job job) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO jobs (job_id, job_desc, min_lvl, max_lvl) " +
                             "VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, job.getJobId());
                stmt.setString(2, job.getJobDesc());
                stmt.setInt(3, job.getMinLvl());
                stmt.setInt(4, job.getMaxLvl());

                stmt.executeUpdate();
                System.out.println("Job added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
 // Método para actualizar un trabajo en la base de datos
    public static void actualizarJob(Job job) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE jobs SET job_desc = ?, min_lvl = ?, max_lvl = ? WHERE job_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, job.getJobDesc());
                stmt.setInt(2, job.getMinLvl());
                stmt.setInt(3, job.getMaxLvl());
                stmt.setInt(4, job.getJobId());

                stmt.executeUpdate();
                System.out.println("Job updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
 // Método para eliminar un trabajo de la base de datos
    public static void eliminarJob(int jobId) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM jobs WHERE job_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, jobId);

                stmt.executeUpdate();
                System.out.println("Job deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
 // Método para cargar los publicadores desde la base de datos
    public static void cargarPublishers(ArrayList<Publisher> publishersList) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM publishers";  // Consulta SQL para obtener los publicadores
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String pubId = rs.getString("pub_id");
                    String pubName = rs.getString("pub_name");
                    String city = rs.getString("city");
                    String state = rs.getString("state");
                    String country = rs.getString("country");

                    Publisher publisher = new Publisher(pubId, pubName, city, state, country);
                    publishersList.add(publisher);  // Añadir el publicador al ArrayList
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Could not establish connection to the database.");
        }
    }

    
 // Método para agregar un nuevo publicador a la base de datos
    public static void agregarPublisher(Publisher publisher) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO publishers (pub_id, pub_name, city, state, country) " +
                             "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, publisher.getPubId());
                stmt.setString(2, publisher.getPubName());
                stmt.setString(3, publisher.getCity());
                stmt.setString(4, publisher.getState());
                stmt.setString(5, publisher.getCountry());

                stmt.executeUpdate();
                System.out.println("Publisher added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    
 // Método para actualizar un publicador en la base de datos
    public static void actualizarPublisher(Publisher publisher) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE publishers SET pub_name = ?, city = ?, state = ?, country = ? WHERE pub_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, publisher.getPubName());
                stmt.setString(2, publisher.getCity());
                stmt.setString(3, publisher.getState());
                stmt.setString(4, publisher.getCountry());
                stmt.setString(5, publisher.getPubId());

                stmt.executeUpdate();
                System.out.println("Publisher updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    
 // Método para eliminar un publicador de la base de datos
    public static void eliminarPublisher(String pubId) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM publishers WHERE pub_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, pubId);

                stmt.executeUpdate();
                System.out.println("Publisher deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    
 // Método para cargar las tiendas desde la base de datos
    public static void cargarStores(ArrayList<Store> storesList) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM stores";  // Consulta SQL para obtener las tiendas
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String storId = rs.getString("stor_id");
                    String storName = rs.getString("stor_name");
                    String storAddress = rs.getString("stor_address");
                    String city = rs.getString("city");
                    String state = rs.getString("state");
                    String zip = rs.getString("zip");

                    Store store = new Store(storId, storName, storAddress, city, state, zip);
                    storesList.add(store);  // Añadir la tienda al ArrayList
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Could not establish connection to the database.");
        }
    }

    
 // Método para agregar una nueva tienda a la base de datos
    public static void agregarStore(Store store) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO stores (stor_id, stor_name, stor_address, city, state, zip) " +
                             "VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, store.getStorId());
                stmt.setString(2, store.getStorName());
                stmt.setString(3, store.getStorAddress());
                stmt.setString(4, store.getCity());
                stmt.setString(5, store.getState());
                stmt.setString(6, store.getZip());

                stmt.executeUpdate();
                System.out.println("Store added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    
 // Método para actualizar una tienda en la base de datos
    public static void actualizarStore(Store store) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE stores SET stor_name = ?, stor_address = ?, city = ?, state = ?, zip = ? WHERE stor_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, store.getStorName());
                stmt.setString(2, store.getStorAddress());
                stmt.setString(3, store.getCity());
                stmt.setString(4, store.getState());
                stmt.setString(5, store.getZip());
                stmt.setString(6, store.getStorId());

                stmt.executeUpdate();
                System.out.println("Store updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    
 // Método para eliminar una tienda de la base de datos
    public static void eliminarStore(String storId) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM stores WHERE stor_id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, storId);

                stmt.executeUpdate();
                System.out.println("Store deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
 // Método para cargar los usuarios desde la base de datos
    public static void cargarUsuarios(ArrayList<Usuario> usuariosList) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM usuario";  // Consulta SQL para obtener los usuarios
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String usuario = rs.getString("usuario");
                    String password = rs.getString("password");
                    int nivel = rs.getInt("nivel");

                    Usuario user = new Usuario(id, usuario, password, nivel);
                    usuariosList.add(user);  // Añadir el usuario al ArrayList
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Could not establish connection to the database.");
        }
    }

    
    
 // Método para agregar un nuevo usuario a la base de datos
    public static void agregarUsuario(Usuario usuario) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO usuario (usuario, password, nivel) " +
                             "VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, usuario.getUsuario());
                stmt.setString(2, usuario.getPassword());
                stmt.setInt(3, usuario.getNivel());

                stmt.executeUpdate();
                System.out.println("Usuario added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    
 // Método para actualizar un usuario en la base de datos
    public static void actualizarUsuario(Usuario usuario) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE usuario SET usuario = ?, password = ?, nivel = ? WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, usuario.getUsuario());
                stmt.setString(2, usuario.getPassword());
                stmt.setInt(3, usuario.getNivel());
                stmt.setInt(4, usuario.getId());

                stmt.executeUpdate();
                System.out.println("Usuario updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    
 // Método para eliminar un usuario de la base de datos
    public static void eliminarUsuario(int id) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM usuario WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);

                stmt.executeUpdate();
                System.out.println("Usuario deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
 // Método para cargar las noticias desde la base de datos
    public static void cargarNoticias(ArrayList<Noticia> noticiasList) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                String sql = "SELECT * FROM noticias";  // Consulta SQL para obtener las noticias
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int idNoticia = rs.getInt("id_noticias");
                    String titulo = rs.getString("titulo");
                    String fecha = rs.getString("fecha");
                    String noticia = rs.getString("noticia");

                    Noticia n = new Noticia(idNoticia, titulo, fecha, noticia);
                    noticiasList.add(n);  // Añadir la noticia al ArrayList
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Could not establish connection to the database.");
        }
    }

    
 // Método para agregar una nueva noticia a la base de datos
    public static void agregarNoticia(Noticia noticia) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO noticias (titulo, fecha, noticia) " +
                             "VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, noticia.getTitulo());
                stmt.setString(2, noticia.getFecha());
                stmt.setString(3, noticia.getNoticia());

                stmt.executeUpdate();
                System.out.println("Noticia added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
 // Método para actualizar una noticia en la base de datos
    public static void actualizarNoticia(Noticia noticia) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "UPDATE noticias SET titulo = ?, fecha = ?, noticia = ? WHERE id_noticias = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, noticia.getTitulo());
                stmt.setString(2, noticia.getFecha());
                stmt.setString(3, noticia.getNoticia());
                stmt.setInt(4, noticia.getIdNoticia());

                stmt.executeUpdate();
                System.out.println("Noticia updated successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
 // Método para eliminar una noticia de la base de datos
    public static void eliminarNoticia(int idNoticia) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                String sql = "DELETE FROM noticias WHERE id_noticias = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, idNoticia);

                stmt.executeUpdate();
                System.out.println("Noticia deleted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
