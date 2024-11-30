import axios from "axios";

const getAll = () => {
  return axios.get('/user/');
}

const getById = (id) => {
  return axios.get(`/user/getById/${id}`);
}

const getByRut = (rut) => {
  return axios.get(`/user/getByRut/${rut}`);
}

const getByEmail = (email) => {
  return axios.get(`/user/getByEmail/${email}`);
}

const create = (data) => {
  return axios.post('/user/save', data);
}

const login = (data) => {
  return axios.post('/user/login', data);
}

const zero = (id) => {
  return axios.post(`/user/setZero/${id}`);
}

const transfer = (userId,creditId) => {
  return axios.post("/user/transfer",{userId, creditId});
}

const update = (data) => {
  return axios.put('/user/update', data);
}

const remove = (id) => {
  return axios.delete(`/user/delete/${id}`);
}

export default { getAll, getById, getByRut, getByEmail, create, login, update, remove, zero, transfer };