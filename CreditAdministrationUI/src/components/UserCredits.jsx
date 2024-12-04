import { useEffect, useState} from "react";
import { Link, useNavigate, useParams} from "react-router-dom";
import CreditScoreSharpIcon from '@mui/icons-material/CreditScoreSharp';
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell, { tableCellClasses } from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import Button from "@mui/material/Button";
import creditService from "../services/credit.service";
import trackingService from "../services/tracking.service";


const UserCredits = () => {
  const [credits, setCredits] = useState([]);
  const [trackings, setTrackings] = useState([]);
  const [isLoading, setIsLoading] = useState(true); // Nuevo estado
  const [userId] = useState(sessionStorage.getItem("userId"));
  const navigate = useNavigate();

  const init = async () => {
    try {
      console.log(userId);

      const creditResponse = await creditService.getByUserId(userId);
      console.log("Mostrando listado de créditos del usuario.", creditResponse.data);
      setCredits(creditResponse.data);

      const creditIdsResponse = await creditService.getListIdsByUserId(userId);
      console.log("Mostrando listado de IDs de créditos del usuario.", creditIdsResponse.data);

      const trackingResponse = await trackingService.getTrackingsByCreditIds(creditIdsResponse.data);
      console.log("Mostrando listado de tracking del usuario.", trackingResponse.data);
      setTrackings(trackingResponse.data);

      setIsLoading(false); // Carga completada
    } catch (error) {
      console.error("Se ha producido un error al cargar los datos:", error);
      setIsLoading(false); // Detenemos la carga incluso en caso de error
    }
  };

  useEffect(() => {
    init();
  }, []);

  const goEvaluation = (data) => {
    sessionStorage.setItem("toEvaluate", JSON.stringify(data));
    navigate("/credit/evaluation");
  };

  if (isLoading) {
    return <p>Cargando datos...</p>;
  }

  return (
    <TableContainer component={Paper}>
      <br />
      <br />
      <br />
      <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            <TableCell align="left" sx={{ fontWeight: "bold" }}>
              Id
            </TableCell>
            <TableCell align="left" sx={{ fontWeight: "bold" }}>
              Tipo de crédito
            </TableCell>
            <TableCell align="right" sx={{ fontWeight: "bold" }}>
              Monto solicitado
            </TableCell>
            <TableCell align="right" sx={{ fontWeight: "bold" }}>
              Plazo
            </TableCell>
            <TableCell align="right" sx={{ fontWeight: "bold" }}>
              Fase de evaluación
            </TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {credits.map((credit, index) => (
            <TableRow
              key={credit.creditId}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell align="left">{credit.creditId}</TableCell>
              <TableCell align="left">
                {credit.creditType === 1 && "Primera vivienda"}
                {credit.creditType === 2 && "Segunda vivienda"}
                {credit.creditType === 3 && "Propiedad comercial"}
                {credit.creditType === 4 && "Remodelación"}
              </TableCell>
              <TableCell align="right">{credit.creditRequestedAmount}</TableCell>
              <TableCell align="center">{credit.creditTerm}</TableCell>
              <TableCell align="center">
                {(() => {
                  const phase = trackings[index]?.trackingPhase; // Manejo de índice seguro
                  switch (phase) {
                    case 0:
                      return "Transferido";
                    case 3:
                      return "En evaluación";
                    case 4:
                      return "Pre-aprobado";
                    case 5:
                      return "Aprobación final";
                    case 6:
                      return "Aprobado";
                    case 7:
                      return "Rechazado";
                    case 9:
                      return "En desembolso";
                    default:
                      return "Fase desconocida";
                  }
                })()}
              </TableCell>
              <TableCell>
                <Button
                  variant="contained"
                  color="info"
                  size="small"
                  onClick={() => goEvaluation(credit)}
                  style={{ marginLeft: "0.5rem" }}
                  startIcon={<CreditScoreSharpIcon />}
                >
                  Ver estado
                </Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default UserCredits;
