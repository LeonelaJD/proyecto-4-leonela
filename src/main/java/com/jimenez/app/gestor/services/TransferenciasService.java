package com.jimenez.app.gestor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jimenez.app.gestor.dao.ITransferenciasDao;
import com.jimenez.app.gestor.dtos.TransferenciaDTO;
import com.jimenez.app.gestor.models.Transferencia;

@Component
public class TransferenciasService implements IService<Transferencia, TransferenciaDTO>{

	//atributos
	@Autowired
	private ITransferenciasDao transferenciasDao;
	
	
	@Override
	public List<Transferencia> listar() {
		// TODO Auto-generated method stub
		List<Transferencia> transferencias = new ArrayList();
		transferencias = (List<Transferencia>) transferenciasDao.findAll();
		return transferencias;
		
	}

	@Override
	public Optional<Transferencia> getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Transferencia> transferencia = transferenciasDao.findById(id);
		return transferencia;
		
	}

	@Override
	public void guardar(TransferenciaDTO transferenciaDto) {
		// TODO Auto-generated method stub
		this.transferenciasDao.save(convertirDTOaIngreso(transferenciaDto));
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		this.transferenciasDao.deleteById(id);
		
	}

	//metodo que permite convertir el DTO al modelo original
	public Transferencia convertirDTOaIngreso(TransferenciaDTO transferenciaDto) {
		Transferencia transferencia = new Transferencia();
		transferencia.setId(transferenciaDto.getId());
		transferencia.setCuentaOrigen(transferenciaDto.getCuentaOrigen());
		transferencia.setCuentaDestino(transferenciaDto.getCuentaDestino());
		transferencia.setMonto(transferenciaDto.getMonto());
		transferencia.setFecha(transferenciaDto.getFecha());
		transferencia.setConcepto(transferenciaDto.getConcepto());
		return transferencia;
	}
}
