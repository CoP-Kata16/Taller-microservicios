package com.microservice.createnotification.pojo;


import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "notification")
public class Notification
{

	private String id;

	private String idType;

	private String title;

	private String description;
	
	private String reference;
	
	private String user;
	

	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}


	/**
	 * @return the idTypo
	 */
	public String getIdType()
	{
		return idType;
	}


	/**
	 * @param idTypo the idTypo to set
	 */
	public void setIdType(String idType)
	{
		this.idType = idType;
	}


	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}


	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Notification [id=" + id + ", idType=" + idType + ", title=" + title + ", description=" + description
				+ ", reference=" + reference + ", user=" + user + "]";
	}




}
