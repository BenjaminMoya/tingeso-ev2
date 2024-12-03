import axios from "axios";

const upload = (id, type, file) => {
    const formData = new FormData();
    formData.append("file", file); 
  
    return axios.post(`/file/upload/${id}/${type}`, formData, {
      headers: {
        'Content-Type': 'multipart/form-data', 
      },
    });
};

const download = async (id, type) => {
    try {
        const response = await axios.get(`/file/download/${id}/${type}`, {
            responseType: 'blob',
        });

        const url = window.URL.createObjectURL(new Blob([response.data]));
        const link = document.createElement('a');
        link.href = url;

        const fileNames = [
            "ComprobanteDeIngresos",
            "CertificadoDeAvaluo",
            "HistorialCrediticio",
            "EscrituraDePrimeraVivienda",
            "EstadoFinancieroDelNegocio",
            "PlanDeNegocios",
            "PresupuestoDeRemodelacion",
            "CertificadoDeAvaluoActualizado",
            "ContratoCrediticio"
        ];

        link.setAttribute('download', `${fileNames[type]}_${id}.pdf`);
        
        document.body.appendChild(link);
        link.click();
        link.remove();

        // Liberar el objeto URL después de usarlo
        window.URL.revokeObjectURL(url);
    } catch (error) {
        console.log("Ha ocurrido un error al intentar descargar el archivo.", error);
    }
}

const deleteFiles = (id) => {
    return axios.delete(`/file/delete/${id}`);
}

export default { upload, download , deleteFiles};