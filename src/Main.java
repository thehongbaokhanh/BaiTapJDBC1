import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionJDBC connectionJDBC = new ConnectionJDBC();
        Connection connection = connectionJDBC.getConnection();
//        Thêm sản phẩm:
//        InsertDataIntoDatabase(connection, "products", "CP000001", "p10", 1000.0, "p10", "p10", 10, 1);
//        Hiển thị bảng:
//        SelectTableDatabase(connection, "products");
//        Cài đặt thay đổi thông tin dựa vào ID:
//        UpdateDetailOfProductsByID(connection, "Dữ liệu mới", "P004");
//        Cài đặt thay đổi nhà sản xuất, giá trên bảng:
//        UpdateManufacturerAndPriceOfProductsByID(connection, "p10", 12000000.0, "P002");
//        Cài đặt thay đổi số sản phẩm và tình trạng trong bảng:
//        UpdateNumberAndStatusOfProductsByID(connection, 9, 0, "P009");
//        Xóa thông tin trong bảng:
//        DeleteDataInDatabasewithID(connection, "P004", "products");
//        Hiển thị bảng dựa vào ID:
//        SelectTableDatabaseByID(connection, "products", "P003");
//        Hiển thị bảng dựa vào 2 ID:
//        SelectTableDatabaseBy2ID(connection, "products", "P003", "P005");
//        Hiển thị bảng dựa từ trạng thái của sản phẩm:
//        SelectTableDatabaseByStatus(connection, "products", 0);
//        Hiển thị thông tin dựa vào trạng thái và số lượng sản phẩm:
//        SelectTableDatabaseByStatusAndNumber(connection, "products", 9, 0);

    }

    private static void SelectTableDatabaseByStatusAndNumber(Connection connection, String tableName, int number, int status) {
        String query = "select * from " + tableName + " where number = " + "'" + number + "' and status = " + "'" + status + "';";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String detail = resultSet.getString("detail");
                String manufacturer = resultSet.getString("manufacturer");
                System.out.println("id = " + id + " || name = " + name + " || price = " + price + " || detail = " + detail + " || manufacturer = " + manufacturer + " || number = " + number + " || status = " + status);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void SelectTableDatabaseByStatus(Connection connection, String tableName, int status) {
        String query = "select * from " + tableName + " where status = " + "'" + status + "';";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String detail = resultSet.getString("detail");
                String manufacturer = resultSet.getString("manufacturer");
                int number = resultSet.getInt("number");
                System.out.println("id = " + id + " || name = " + name + " || price = " + price + " || detail = " + detail + " || manufacturer = " + manufacturer + " || number = " + number + " || status = " + status);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void SelectTableDatabaseBy2ID(Connection connection, String tableName, String id1, String id2) {
        String query = "select * from " + tableName + " where id = " + "'" + id1 + "' or id = " + "'" + id2 + "';";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String detail = resultSet.getString("detail");
                String manufacturer = resultSet.getString("manufacturer");
                int number = resultSet.getInt("number");
                int status = resultSet.getInt("status");
                System.out.println("id = " + id + " || name = " + name + " || price = " + price + " || detail = " + detail + " || manufacturer = " + manufacturer + " || number = " + number + " || status = " + status);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void SelectTableDatabaseByID(Connection connection, String tableName, String id) {
        String query = "select * from " + tableName + " where id = " + "'" + id + "';";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String detail = resultSet.getString("detail");
                String manufacturer = resultSet.getString("manufacturer");
                int number = resultSet.getInt("number");
                int status = resultSet.getInt("status");
                System.out.println("id = " + id + " || name = " + name + " || price = " + price + " || detail = " + detail + " || manufacturer = " + manufacturer + " || number = " + number + " || status = " + status);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void DeleteDataInDatabasewithID(Connection connection, String id, String tableName) {
        String query = "delete from " + tableName + " where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Xóa thành công.");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void UpdateNumberAndStatusOfProductsByID(Connection connection, int number, int status, String id) {
        String query = "UPDATE products SET number = " + "'" + number + "', status = " + "'" + status + "'" + " WHERE id = ? ;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            System.out.println("cập nhật thành công.");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void UpdateDetailOfProductsByID(Connection connection, String detail, String id) {
        String query = "UPDATE products SET detail = " + "'" + detail + "'" + " WHERE id = ? ;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            System.out.println("cập nhật thành công.");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void UpdateManufacturerAndPriceOfProductsByID(Connection connection, String manufacturer, double price, String id) {
        String query = "UPDATE products SET detail = " + "'" + manufacturer + "', price = " + "'" + price + "'" + " WHERE id = ? ;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            System.out.println("cập nhật thành công.");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void InsertDataIntoDatabase(Connection connection, String tableName, String id, String name, Double price, String detail, String manufacturer, int number, int status) {
        String query = "insert into products (id, name, price, detail, manufacturer, number, status) values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatements = null;
        try {
            preparedStatements = connection.prepareStatement(query);
            preparedStatements.setString(1, id);
            preparedStatements.setString(2, name);
            preparedStatements.setDouble(3, price);
            preparedStatements.setString(4, detail);
            preparedStatements.setString(5, manufacturer);
            preparedStatements.setInt(6, number);
            preparedStatements.setInt(7, status);
            int row = preparedStatements.executeUpdate();
            connection.close();
            if (row != 0) {
                System.out.println("Thêm thành công " + row + " sản phẩm.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void SelectTableDatabase(Connection connection, String tableName) {
        String query = "select * from " + tableName;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                String detail = resultSet.getString("detail");
                String manufacturer = resultSet.getString("manufacturer");
                int number = resultSet.getInt("number");
                int status = resultSet.getInt("status");
                System.out.println("id = " + id + " || name = " + name + " || price = " + price + " || detail = " + detail + " || manufacturer = " + manufacturer + " || number = " + number + " || status = " + status);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}