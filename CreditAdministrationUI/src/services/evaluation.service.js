import axios from "axios";

const create = (creditId) => {
    return axios.post('/evaluation/save/', {evaluationId: null, evaluationCreditId: creditId, evaluationRelationCi: 0, evaluationRelationDi: 0});
}

const zero = (id) => {
    return axios.post(`/evaluation/setZero/${id}`);
}

const getByCreditId = (id) => {
    return axios.get(`/evaluation/getByCreditId/${id}`);
}

const relationCi = (creditId, requestedAmount, interest, years, monthlyEntry) => {
    console.log("relationCi", creditId, requestedAmount, interest, years, monthlyEntry);
    return axios.get(`/evaluation/relationCI/${creditId}/${requestedAmount}/${interest}/${years}/${monthlyEntry}`);
}

const relationDi = (creditId, monthlyAmount, debtsMonthlyAmount, creditMonthlyAmount) => {
    console.log("relationDi", creditId, monthlyAmount, debtsMonthlyAmount, creditMonthlyAmount);    
    return axios.get(`/evaluation/relationDI/${creditId}/${monthlyAmount}/${debtsMonthlyAmount}/${creditMonthlyAmount}`);
}

const min = (userId,creditId, amount) => {
    return axios.post(`/evaluation/min/${userId}/${creditId}/${amount}`);
};

const history = (creditId,great) => {
    return axios.post(`/evaluation/history/${creditId}/${great}`);
}

const periodic = (creditId,deposit,entry,periodic) => {
    return axios.post(`/evaluation/periodic/${creditId}/${deposit}/${entry}/${periodic}`);
}

const relation = (userId,creditId,amount) => {
    return axios.post(`/evaluation/relation/${userId}/${creditId}/${amount}`);
}

const out = (userId,creditId,max) => {
    return axios.post(`/evaluation/out/${userId}/${creditId}/${max}`);
}

export default { create, zero, getByCreditId, relationCi, relationDi, min, history, periodic, relation, out };