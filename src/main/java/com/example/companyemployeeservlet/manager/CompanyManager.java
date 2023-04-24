package com.example.companyemployeeservlet.manager;



import com.example.companyemployeeservlet.db.DBConnectionProvider;
import com.example.companyemployeeservlet.model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyManager {

    private static Connection connection = DBConnectionProvider.getInstance().getConnection();

    public static void save(Company company) {
        String sql = "INSERT INTO company(name,country) VALUES(?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, company.getName());
            ps.setString(2, company.getCountry());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                company.setId(generatedKeys.getInt(1));
            }
            System.out.println("company inserted into DB");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Company company) {
        String sql = "UPDATE company SET name = '%s', country = '%s' WHERE id = %d";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format(sql, company.getName(), company.getCountry(), company.getId()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Company> getAll() {
        List<Company> companyList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from company ");
            while (resultSet.next()) {

                companyList.add(getCompanyFromResultSet(resultSet));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companyList;
    }

    public List<Company> getByCountry(String country) {
        List<Company> companyList = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement("Select * from company where country = ?");
            ps.setString(1, country);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Company company = getCompanyFromResultSet(resultSet);
                companyList.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companyList;
    }

    public void removeById(int companyId) {
        String sql = "DELETE FROM company WHERE id = " + companyId;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Company getCompanyFromResultSet(ResultSet resultSet) throws SQLException {
        Company company = new Company();
        company.setId(resultSet.getInt("id"));
        company.setName(resultSet.getString("name"));
        company.setCountry(resultSet.getString("country"));
        return company;
    }


    public Company getById(int id) {


        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("Select * from company where id = " + id);
            if (resultSet.next()) {
                return getCompanyFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Company getByName(String name) {


        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("Select * from company where name = " + name);
            if (resultSet.next()) {
                return getCompanyFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
