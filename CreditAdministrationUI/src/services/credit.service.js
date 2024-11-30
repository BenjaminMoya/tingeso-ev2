import axios from "axios";

const getById = (id) => {
    return axios.get(`/credit/getById/${id}`);
}

const getByUserId = (id) => {
    return axios.get(`/credit/getByUserId/${id}`);
}

const getListByIds = (list) => {
    return axios.get(`/credit/listByIds/${list}`);
}

const create = (data) => {
  return axios.post('/credit/save', data);
}

const update = (data) => {
    return axios.put('/credit/update', data);
}

const deleteCredit = (id) => {
    return axios.delete(`/credit/delete/${id}`);
}

export default { getById, getByUserId, getListByIds, create, update, deleteCredit };