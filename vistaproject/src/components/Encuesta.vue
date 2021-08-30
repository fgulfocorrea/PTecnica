<template>
    <Fieldset :legend="titulo" style="height: 500px">
      Cliente: {{selectedCliente.nombres}}
        <ScrollPanel style="width: 100%; height: 400px" class="custom">
          <Card v-for="pregunta in preguntas" :key="pregunta.id">
            <template #title>
                {{pregunta.numero}}. {{pregunta.texto}}
            </template>
            <Divider type="dashed"/>
            <template #content>
              <div v-for="opcion in pregunta.opciones" :key="opcion.id" class="p-field-radiobutton">
                <RadioButton @click.prevent="addRespuesta(pregunta.id,opcion.id)" :id="opcion.id" :name="opcion.id" :value="opcion.codigo" v-model="pregunta.numero" />
                <label :for="opcion.id">{{opcion.codigo}} {{opcion.nombre}}</label>
              </div>
            </template>
          </Card>
          </ScrollPanel>
        <Toolbar>
          <template #left>
              <Button label="Atras" @click="$router.push('/')" icon="pi pi-arrow-left" class="p-mr-2 p-mb-2"/>
            </template>
            <template #right>
                <Button label="Guardar" @click.prevent="guardarRespuesta()" icon="pi pi-save" class="p-mb-2" />
            </template>
        </Toolbar>
        <Toast position="top-right" />
    </Fieldset>
</template>

<script>
/* eslint-disable */
import PreguntaServicio from '@/services/PreguntaServicio';
import RespuestaServicio from '@/services/RespuestaServicio'


import Fieldset from 'primevue/fieldset';
import Toolbar from 'primevue/toolbar';
import Button from 'primevue/button';
import Card from 'primevue/card';
import Divider from 'primevue/divider';
import RadioButton from 'primevue/radiobutton';
import Toast from 'primevue/toast';
import ScrollPanel from 'primevue/scrollpanel';

export default {
    name: 'Encuesta',
    props:['id'],
    components: {
        Fieldset,
        Toolbar,
        Button,
        Card,
        Divider,
        RadioButton,
        Toast,
        ScrollPanel
    },
    data (){
      return {
        titulo: "",
        encuesta:{
          id:0,
          nombre:""
        },
        preguntas:[],
        opciones:[],
        clientes:[],
        respuestas:[],
        selectedOpcion:null,
        selectedCliente:{},
        respuesta:{
          id:null,
          idEncuesta:null,
          idPregunta:null,
          idOpcion:null,
          cliente:{}
        }
      }
    },
    methods: {

      async obtenerListadoPreguntas() {
        const response = await PreguntaServicio.obtenerPreguntas();
        console.log(response.data)
        this.preguntas = response.data.listaPreguntas
        
        // this.listaUsuarios();
        // this.obtenerCantidadMonedas()
      },
      async obtenerPreguntasPorEncuesta(){
          const response = await PreguntaServicio.obtenerPreguntasPorEncuesta({
            idEncuesta: this.$route.params.id
          });

          console.log(response.data)
          this.preguntas = response.data.listaPreguntas
          this.opciones = response.data.listaPreguntas.opciones
          this.encuesta = response.data.encuesta
          this.titulo = this.encuesta.nombre
          this.selectedCliente = response.data.cliente
      },
      async addRespuesta(idPregunta,idOpcion){
        this.respuesta.id = this.respuestas.length + 1
        this.respuesta.idEncuesta = this.encuesta.id
        this.respuesta.idPregunta = idPregunta
        this.respuesta.idOpcion = idOpcion
        this.respuesta.cliente = this.selectedCliente
        var copia = Object.assign({}, this.respuesta);
        console.log(JSON.parse(JSON.stringify(this.respuesta)))
        this.respuestas.push(copia)
        this.limpiarObjeto()
        for (let index = 0; index < this.respuestas.length; index++) {
          const element = this.respuestas[index];
          console.log("obj:"+JSON.stringify(element))
        }
        
      },
      async guardarRespuesta(){
        if(this.respuestas.length != 0){
          const response = await RespuestaServicio.guardar(this.respuestas);
          this.$toast.add({severity:'success', summary: 'Excelente', detail:'Encuesta Guardada', life: 3000});
        }else{
          console.log("debe elegir respuestas!")
          this.$toast.add({severity:'error', summary: 'Error', detail:'Debe elegir las respuestas', life: 3000});
        }
      },
      limpiarObjeto() {
          this.respuesta.id = null
          this.respuesta.idEncuesta = null
          this.respuesta.idPregunta = null
          this.respuesta.idOpcion = null
        },
    },
    mounted() {
        // this.obtenerListadoPreguntas();
        console.log(this.$route.params.id)
        this.obtenerPreguntasPorEncuesta();
    },
}
</script>

<style>
.titulo1{
  border-bottom-style: inset
}
.custom .p-scrollpanel-wrapper {
    border-right: 9px solid #BDBCBC;
}

.custom .p-scrollpanel-bar {
    background-color: #1976d2;
    opacity: 1;
    transition: background-color .3s;
}

.custom .p-scrollpanel-bar:hover {
    background-color: #135ba1;
}
</style>