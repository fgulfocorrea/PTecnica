import Api from '@/services/Api'
/* eslint-disable */
export default {
    obtenerResponsables(params) {
        return Api().get('responsable')
    },
}