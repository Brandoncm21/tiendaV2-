package com.tienda.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    String BUCKET_NAME = "techshop-5e5bc.appspot.com";
    String RUTA_SUPERIOR_STORAGE = "techshop";
    String RUTA_JSON_FILE = "firebase";
    String ARCHIVO_JSON_FILE = "techshop-5e5bc-firebase-adminsdk-gg77e-80f472a917.json";

}
