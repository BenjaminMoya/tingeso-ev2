import axios from "axios";

const getSimulation = (amount,interest,years) => {
  return axios.get(`/simulation/${amount}/${interest}/${years}`);
}

const create = (amount,interest,years,userId) => {
    return axios.post(`/simulation/save/${amount}/${interest}/${years}/${userId}`);
}

export default { getSimulation, create };