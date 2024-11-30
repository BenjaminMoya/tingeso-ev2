import axios from "axios";

const getByTrackingCreditId = (id) => {
    return axios.get(`/tracking/getByTrackingCreditId/${id}`);
}

const getCreditIdsByPhase = (phase) => {
    return axios.get(`/tracking/getTrackingCreditIds/${phase}`);
}

const create = (data) => {
    return axios.post('/tracking/save', data);
}

const update = (data) => {
    return axios.put('/tracking/update', data);
}

const deleteTracking = (id) => {
    return axios.delete(`/tracking/delete/${id}`);
}

export default { getByTrackingCreditId, getCreditIdsByPhase, create, update, deleteTracking };