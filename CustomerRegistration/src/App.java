import br.com.rcurvo.dao.CustomerMapDAO;
import br.com.rcurvo.dao.ICustomerDAO;
import br.com.rcurvo.domain.Customer;

import javax.swing.*;

public class App {
    private static ICustomerDAO iCustomerDAO;
    public static void main(String[] args) {
        iCustomerDAO = new CustomerMapDAO();

        String option = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, ou 5 para sair",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isValidOption(option)) {
            if("".equals(option)) {
                exitProgram();
            }
            option = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, ou 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isValidOption(option)) {
            if(isOptionExit(option)) {
                exitProgram();
            } else if (isOptionRegister(option)) {
                String data = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vírgula, conforme modelo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                registerClient(data);
            } else if (isOptionSearch(option)) {
                String data = JOptionPane.showInputDialog(null,
                        "Digite o cpf",
                        "Consultar", JOptionPane.INFORMATION_MESSAGE);

                searchCustomer(data);
            }
            option = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, ou 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static void searchCustomer(String data) {
        Customer customer = iCustomerDAO.search(Long.parseLong(data));
        if (customer != null) {
            JOptionPane.showMessageDialog(null,
                    "Cliente encontrado: " + customer.toString(),
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Cliente não encontrado",
                    "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isOptionSearch(String option) {
        if("2".equals(option)) {
            return true;
        }
        return false;
    }

    private static boolean isOptionExit(String option) {
        if("5".equals(option)) {
            return true;
        }
        return false;
    }

    private static void registerClient(String data) {
        String [] dataSplit = data.split(",");
        Customer customer = new Customer(dataSplit[0], dataSplit[1], dataSplit[2], dataSplit[3], dataSplit[4], dataSplit[5], dataSplit[6]);
        Boolean isRegistered = iCustomerDAO.register(customer);
        if (isRegistered) {
            JOptionPane.showMessageDialog(null,
                    "Cliente cadastrado com sucesso",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Cliente já se encontra cadastrado",
                    "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void exitProgram() {
        JOptionPane.showMessageDialog(null, "Até logo: ", "Sair",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isValidOption(String option) {
        if("1".equals(option) || "2".equals(option) || "3".equals(option) || "4".equals(option) || "5".equals(option)) {
            return true;
        }
        return false;
    }

    private static boolean isOptionRegister(String option) {
        if("1".equals(option)) {
            return true;
        }
        return false;
    }

}