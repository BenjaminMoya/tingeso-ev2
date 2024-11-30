import axios from "axios";

const getAll = () => {
  return axios.get('/evaluation/');
}

const saveEvaluation = (amount,interest,years,userId) => {
    return axios.post(`/evaluation/save/${amount}/${interest}/${years}/${userId}`);
}

export default { saveEvaluation, getAll };