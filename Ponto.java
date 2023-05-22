public class Ponto {
    public String time;
    public String location;

    public Ponto() {

    }

    public Ponto(String time, String location) {
        this.time = time;
        this.location = location;
    }

    public boolean isValidTimeFormat(String time) {
        //ve se n tem 5 char (se não ta invalido) -> #TODO: add validador pra 0 à esqueda do primeiro numero
        if (time.length() != 5) {
            return false;
        }

        // dois pontos exatamente no meio
        if (time.charAt(2) != ':') {
            return false;
        }

        // split no :
        String[] parts = time.split(":");

        // teve transformar em 2 (array!!)
        if (parts.length != 2) {
            return false;
        }

        // ve se as duas partes tem só 2 numeros
        if (parts[0].length() != 2 || parts[1].length() != 2) {
            return false;
        }

        try {
            // da parse pra inteiro
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);

            // ve se ta 0 ~ 23
            if (hours < 0 || hours > 23) {
                return false;
            }

            // ve se ta de 0 ~ 59
            if (minutes < 0 || minutes > 59) {
                return false;
            }
        } catch (NumberFormatException e) {
            // exception do parse
            return false;
        }

        // ta certo
        return true;
    }

    public void setTime(String time) {
        if (isValidTimeFormat(time)) {
            this.time = time;
        } else {
            System.out.println("Formato de hora inválido!! Use o formato 24hrs (00:00)");
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
