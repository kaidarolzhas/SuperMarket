import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import Class.Customer;
import Database.Packagedata;
import Class.Alco;
import Class.Food;
import Class.Product;

public class Main {
    public static MainFrame frame;


    public static void connect(Packagedata pd) {
        try {
            Socket socket = new Socket("127.0.0.1", 3131);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if (pd.getOperationType().equals("ADD CUSTOMER") || pd.getOperationType().equals("ADD ALCO")) {
                outputStream.writeObject(pd);
            }
            else if (pd.getOperationType().equals("ADD FOOD") || pd.getOperationType().equals("ADD PRODUCT") || pd.getOperationType().equals("ADD CARD")) {
                outputStream.writeObject(pd);

            }
            if (pd.getOperationType().equals("UPDATE PRODUCT") || pd.getOperationType().equals("DELETE PRODUCT")) {
                outputStream.writeObject(pd);
            }
            else if (pd.getOperationType().equals("LIST ALCO")) {
                outputStream.writeObject(pd);
                Packagedata infoFromServer = (Packagedata) inputStream.readObject();
                ArrayList<Alco> arrayListFromServer = infoFromServer.getAlcoArrayList();
                String s = "";

                for (int i = 0; i < arrayListFromServer.size(); i++) {
                    s += arrayListFromServer.get(i).toString() + "\n";
                }
                ListMenu.textArea.setText(s);
                BuyProduct.textArea.append(s);
            }
            else if (pd.getOperationType().equals("LIST FOOD")) {
                outputStream.writeObject(pd);
                Packagedata infoFromServer = (Packagedata) inputStream.readObject();
                ArrayList<Food> arrayListFromServer = infoFromServer.getFoodArrayList();
                String s = "";

                for (int i = 0; i < arrayListFromServer.size(); i++) {
                    s += arrayListFromServer.get(i).toString() + "\n";
                }
                ListMenu.textArea.setText(s);
                BuyProduct.textArea.append(s);
            }
            else if (pd.getOperationType().equals("LIST PRODUCT")) {
                outputStream.writeObject(pd);
                Packagedata infoFromServer = (Packagedata) inputStream.readObject();
                ArrayList<Product> arrayListFromServer = infoFromServer.getProductArrayList();
                String s = "";

                for (int i = 0; i < arrayListFromServer.size(); i++) {
                    s += arrayListFromServer.get(i).toString() + "\n";
                }
                ListMenu.textArea.setText(s);
                BuyProduct.textArea.append(s);
            }
            else if (pd.getOperationType().equals("GET USER")) {
                outputStream.writeObject(pd);
                Packagedata infoFromServer = (Packagedata) inputStream.readObject();
                Customer customer = infoFromServer.getCustomer();

                Menu.customer = customer;
                UserMenu.customer = customer;
            }

            else if (pd.getOperationType().equals("GET AGE")) {
                outputStream.writeObject(pd);
                Packagedata infoFromServer = (Packagedata) inputStream.readObject();
                Alco customer = infoFromServer.getAlco();

                BuyProduct.alco = customer;
            }
            else if (pd.getOperationType().equals("LIST CARD")) {
                outputStream.writeObject(pd);
                Packagedata infoFromServer = (Packagedata) inputStream.readObject();
                ArrayList<Product> arrayListFromServer = infoFromServer.getProductArrayList();
                String s = "";

                for (int i = 0; i < arrayListFromServer.size(); i++) {
                    s += arrayListFromServer.get(i).toString() + "\n";
                }
                UserMenu.info.setText(s);
            }
            /*else if (pd.getOperationType().equals("ADD PLANE TICKET")) {
                outputStream.writeObject(pd);

            } else if (pd.getOperationType().equals("ADD CARD")) {
                outputStream.writeObject(pd);

            } else if (pd.getOperationType().equals("LIST TRAIN")) {
                outputStream.writeObject(pd);
                Package infoFromServer = (Package) inputStream.readObject();
                ArrayList<TrainTicket> arrayListFromServer = infoFromServer.getTrainTickets();
                String s = "";

                for (int i = 0; i < arrayListFromServer.size(); i++) {
                    s += arrayListFromServer.get(i) + "\n";
                }
                AdminMenu.textArea.setText(s);
            } else if (pd.getOperationType().equals("LIST PLANE")) {
                outputStream.writeObject(pd);
                Package infoFromServer = (Package) inputStream.readObject();
                ArrayList<PlaneTicket> arrayListFromServer = infoFromServer.getPlaneTickets();
                String s = "";

                for (int i = 0; i < arrayListFromServer.size(); i++) {
                    s += arrayListFromServer.get(i) + "\n";
                }
                AdminMenu.textArea.setText(s);
            } else if (pd.getOperationType().equals("FIND TRAIN")) {
                outputStream.writeObject(pd);
                Package infoFromServer = (Package) inputStream.readObject();
                ArrayList<TrainTicket> arrayListFromServer = infoFromServer.getTrainTickets();
                String s = "";

                for (int i = 0; i < arrayListFromServer.size(); i++) {
                    s += arrayListFromServer.get(i) + "\n";
                }
                FindTrainTicket.textArea.setText(s);
            } else if (pd.getOperationType().equals("FIND PLANE")) {
                outputStream.writeObject(pd);
                Package infoFromServer = (Package) inputStream.readObject();
                ArrayList<PlaneTicket> arrayListFromServer = infoFromServer.getPlaneTickets();
                String s = "";

                for (int i = 0; i < arrayListFromServer.size(); i++) {
                    s += arrayListFromServer.get(i) + "\n";
                }
                FindPlaneTicket.textArea.setText(s);
            } else if (pd.getOperationType().equals("GET CUSTOMER")) {
                outputStream.writeObject(pd);
                Package infoFromServer = (Package) inputStream.readObject();
                Customer customer = infoFromServer.getCustomer();

                Login.customer = customer;
            } else if (pd.getOperationType().equals("GET TICKET")) {
                outputStream.writeObject(pd);
                Package infoFromServer = (Package) inputStream.readObject();
                Ticket customer = infoFromServer.getTicket();

                FindPlaneTicket.ticket = customer;
                FindTrainTicket.ticket = customer;
            } else if (pd.getOperationType().equals("LIST CARD")) {
                outputStream.writeObject(pd);
                Package infoFromServer = (Package) inputStream.readObject();
                ArrayList<Ticket> arrayListFromServer = infoFromServer.getTickets();
                String s = "";

                for (int i = 0; i < arrayListFromServer.size(); i++) {
                    s += arrayListFromServer.get(i).info() + "\n";
                }
                UserMenu.textArea.setText(s);
            }

             */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);


    }



}

