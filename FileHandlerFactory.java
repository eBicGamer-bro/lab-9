
public class FileHandlerFactory {
    public static FileHandler createHandler(String type) {
        if (type.equalsIgnoreCase("csv")) {
            return new CSVFileHandler();
        }
        throw new IllegalArgumentException("Unsupported file type");
    }
}
