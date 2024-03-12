package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistroController {
    private String os() {
        return System.getProperty("os.name");
    }

    public void exibeDistro() {
        if (os().contains("Linux")) {
            try {
                Process process = Runtime.getRuntime().exec("cat /etc/os-release");
                BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String linha;
                while ((linha = buffer.readLine()) != null) {
                    if (linha.startsWith("NAME") || linha.startsWith("VERSION")) {
                        System.out.println(linha);
                    }
                }
                buffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Este SO não é Linux, portanto o comando não irá funcionar.");
        }
    }
}
