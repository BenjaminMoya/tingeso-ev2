import axios from "axios";

const getByCreditId = (id) => {
    return axios.get(`/cost/getByCreditId/${id}`);
}

const create = (requestedAmount, interest, years, creditId) => {
    return axios.post(`/cost/save/${requestedAmount}/${interest}/${years}/${creditId}`);
}

const deleteCost = (id) => {
    return axios.delete(`/cost/delete/${id}`);
}

export default { getByCreditId, create, deleteCost };